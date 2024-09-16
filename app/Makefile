.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew build

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app src/test/resources/fixtures/nested1.json src/test/resources/fixtures/nested2.json

run-dist-withArgs:
	./build/install/app/bin/app $(FILE1) $(FILE2)

run-dist-withThreeArgs:
	./build/install/app/bin/app -f $(FORMAT) $(FILE1) $(FILE2)
run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

help:
	./build/install/app/bin/app -h



install-dist:
	./gradlew installDist

build-run: build run

do-all: clean build install-dist run-dist report

.PHONY: build