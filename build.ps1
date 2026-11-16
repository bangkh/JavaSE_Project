$ErrorActionPreference = "Stop"
Push-Location $PSScriptRoot
try {
    if (-not (Get-Command javac -ErrorAction SilentlyContinue)) { throw "JDK 21 is required. Check javac -version and PATH." }
    New-Item -ItemType Directory -Force -Path out | Out-Null
    $sources = @(Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
    & javac -encoding UTF-8 -d out $sources
    if ($LASTEXITCODE -ne 0) { throw "Compilation failed." }
    Write-Host "Build complete. Example: java -cp out chapter1.first.HelloWorld"
} finally {
    Pop-Location
}
