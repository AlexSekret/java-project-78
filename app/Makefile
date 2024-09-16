.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew build

install:
	./gradlew clean install

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

install-dist:
	./gradlew installDist

build-run: build run

#do-all: clean build install-dist run-dist report

.PHONY: build
