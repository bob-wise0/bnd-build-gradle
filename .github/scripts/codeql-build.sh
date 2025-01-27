#!/usr/bin/env bash
set -ev
./gradlew --no-daemon --version
./mvnw --version
./gradlew --no-daemon -Dmaven.repo.local=dist/m2 --continue testClasses :dist:jarDependencies "$@"
./gradlew --no-daemon -Dmaven.repo.local=dist/m2 --continue :gradle-plugins:testClasses
./mvnw -Dmaven.repo.local=dist/m2 --batch-mode --no-transfer-progress --file=maven test-compile
