# Fluent Assertions for JUnit 5

[![Build Status](https://secure.travis-ci.org/toberkoe/fluent-assertions.png)](http://travis-ci.org/toberkoe/fluent-assertions) 
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=de.toberkoe%3Afluent-assertions&metric=coverage)](https://sonarcloud.io/dashboard?id=de.toberkoe%3Afluent-assertions) 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=de.toberkoe%3Afluent-assertions&metric=alert_status)](https://sonarcloud.io/dashboard?id=de.toberkoe%3Afluent-assertions)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.toberkoe/fluent-assertions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.toberkoe/fluent-assertions)

Set of Fluent Assertions for Unit Tests. 
Inspired by [FEST Fluent Assertions 2.x](https://github.com/alexruiz/fest-assert-2.x).

## Latest release

The most recent release is [fluent-assertions 0.4][current release], released 2018-03-20.

The Maven group ID is `de.toberkoe`, and the artifact ID is `fluent-assertions`. Use
version `0.4` for the current version.

To add a dependency on fluent-assertions using Maven, use the following:

```xml
<dependency>
  <groupId>de.toberkoe</groupId>
  <artifactId>fluent-assertions</artifactId>
  <version>0.4</version>
  <scope>test</scope>
</dependency>
```

To add a dependency using Gradle:

```
dependencies {
  testImplementation 'de.toberkoe:fluent-assertions:0.4'
}
```

## Examples
Use ```de.toberkoe.fluentassertions.api.Assertions#assertThat``` as entry point for type-specific fluent assertions.
To make tests more readable, it is recommendend to access this class as a static import.

```java
import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
...

List<Integer> numbers = List.of(1, 2, 3, 4, 5);
assertThat(numbers)
  .isNotEmpty()
  .hasSizeOf(5)
  .startsWith(1, 2, 3)
  .doesNotHaveDuplicates();
```

[current release]: https://github.com/toberkoe/fluent-assertions/releases/tag/0.4
