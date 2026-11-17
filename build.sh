#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
compiler=javac
if [[ -n "${JAVA_HOME:-}" ]]; then
    compiler="$JAVA_HOME/bin/javac"
fi
if ! command -v "$compiler" >/dev/null 2>&1; then
    echo "Install JDK 8 and configure JAVA_HOME or PATH." >&2
    exit 1
fi
version=$("$compiler" -version 2>&1)
case "$version" in
    "javac 1.8."*) ;;
    *) echo "This course uses JDK 8. Found: $version" >&2; exit 1 ;;
esac
source_root=src/lesson
if [[ $# -gt 1 ]]; then
    echo "Usage: bash build.sh [--all]" >&2
    exit 1
fi
case "${1:-}" in
    "") ;;
    --all) source_root=src ;;
    *) echo "Usage: bash build.sh [--all]" >&2; exit 1 ;;
esac
sources=()
while IFS= read -r -d '' file; do
    sources+=("$file")
done < <(find "$source_root" -type f -name '*.java' -print0)
if [[ ${#sources[@]} -eq 0 ]]; then
    echo "No Java source files found." >&2
    exit 1
fi
mkdir -p out
"$compiler" -encoding UTF-8 -source 1.8 -target 1.8 -d out "${sources[@]}"
echo "Build complete: ${#sources[@]} Java files."
echo "Run: java -cp out lesson.step05.RelationshipDemo"
