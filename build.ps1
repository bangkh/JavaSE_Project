param([switch]$All)
$ErrorActionPreference = "Stop"
Push-Location $PSScriptRoot
try {
    $compiler = "javac"
    if ($env:JAVA_HOME) {
        $compiler = Join-Path $env:JAVA_HOME "bin\javac.exe"
        if (-not (Test-Path $compiler)) { throw "JAVA_HOME does not contain bin\javac.exe." }
    } elseif (-not (Get-Command javac -ErrorAction SilentlyContinue)) {
        throw "Install JDK 8 and configure JAVA_HOME or PATH."
    }
    $oldPreference = $ErrorActionPreference
    $ErrorActionPreference = "Continue"
    $version = (& $compiler -version 2>&1 | Out-String).Trim()
    $versionExit = $LASTEXITCODE
    $ErrorActionPreference = $oldPreference
    if ($versionExit -ne 0 -or $version -notmatch '^javac 1\.8\.') {
        throw "This course uses JDK 8. Found: $version"
    }
    $sourceRoot = "src/lesson"
    if ($All) { $sourceRoot = "src" }
    $sources = @(Get-ChildItem -Path $sourceRoot -Recurse -Filter *.java | ForEach-Object { $_.FullName })
    if ($sources.Count -eq 0) { throw "No Java source files found." }
    New-Item -ItemType Directory -Force -Path out | Out-Null
    & $compiler -encoding UTF-8 -source 1.8 -target 1.8 -d out $sources
    if ($LASTEXITCODE -ne 0) { throw "Compilation failed." }
    Write-Host "Build complete: $($sources.Count) Java files."
    Write-Host "Run: java -cp out lesson.step05.RelationshipDemo"
} finally {
    Pop-Location
}
