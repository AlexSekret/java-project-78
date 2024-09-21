### Hexlet tests and linter status:
[![Actions Status](https://github.com/AlexSekret/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AlexSekret/java-project-78/actions) [![Java CI with Gradle](https://github.com/AlexSekret/java-project-78/actions/workflows/gradle.yml/badge.svg)](https://github.com/AlexSekret/java-project-78/actions/workflows/gradle.yml) [![Maintainability](https://api.codeclimate.com/v1/badges/0f56dd6b6a799ae7f49a/maintainability)](https://codeclimate.com/github/AlexSekret/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/0f56dd6b6a799ae7f49a/test_coverage)](https://codeclimate.com/github/AlexSekret/java-project-78/test_coverage)

### Description
Data Validator is both a learning project and a library that can be used to check the correctness of any data. There are many such libraries in every language, since almost all programs work with external data that needs to be checked for correctness.
This learning project aimed at pumping up the design of architecture in an object-oriented style.
Some knowledge of OOP was applied here: design of class structure, composition of objects, inheritance and fluent interface.

### Example of use:
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// Strings
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

//Numbers
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Map object with support for structure checking
Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("firstName", "Anna");
human2.put("lastName", "B");
schema.isValid(human2); // false
```
