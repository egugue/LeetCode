#!/usr/bin/env sh

set -eu

git_root_dir=$(git rev-parse --show-superproject-working-tree --show-toplevel | head -1)

collect_java_solutions() {
  echo ""
  echo "collect java solutions..."
  prev_dir=$(pwd)

  cd "$git_root_dir/jvm/"
  command ./gradlew shadowJar
  command java -jar "./build/libs/solutions.jar" src/main/java/ > "$git_root_dir/tools/readme/assets/solutions/java.json"

  cd "$prev_dir"
  echo "finish"
}

collect_ptyhon3_solutions() {
  echo ""
  echo "collect python3 solutions..."

  prev_dir=$(pwd)

  cd "$git_root_dir/python/"
  pipenv install
  pipenv run solutions > "$git_root_dir/tools/readme/assets/solutions/python3.json"

  cd "$prev_dir"
  echo "finish"
}

write_readme() {
  echo ""
  echo "write readme..."

  prev_dir=$(pwd)

  cd "$git_root_dir/tools/readme"
  command go build -o readme main.go
  command ./readme

  cd "$prev_dir"
  echo "finish"
}

cd "$git_root_dir"

collect_java_solutions
collect_ptyhon3_solutions
write_readme
