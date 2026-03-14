# jFairy by Devskiller

[![Build](https://github.com/SkillPanel/jfairy/actions/workflows/build.yml/badge.svg)](https://github.com/SkillPanel/jfairy/actions/workflows/build.yml) [![Maven Central](https://img.shields.io/maven-central/v/com.devskiller/jfairy)](https://central.sonatype.com/artifact/com.devskiller/jfairy) [![Javadocs](https://javadoc.io/badge2/com.devskiller/jfairy/javadoc.svg)](https://javadoc.io/doc/com.devskiller/jfairy)

Java fake data generator. Based on Wikipedia:

> Fairyland, in folklore, is the fabulous land or abode of fairies or fays.

## Installation

```xml
<dependency>
    <groupId>com.devskiller</groupId>
    <artifactId>jfairy</artifactId>
    <version>0.7.2</version>
</dependency>
```

## Usage

Creating simple objects:

```java
Fairy fairy = Fairy.create();
Person person = fairy.person();

System.out.println(person.getFirstName());
// Chloe
System.out.println(person.getLastName());
// Barker
System.out.println(person.getEmail());
// barker@yahoo.com
System.out.println(person.getTelephoneNumber());
// 690-950-802
System.out.println(person.getJobTitle());
// Software Developer

Person adultMale = fairy.person(PersonProperties.male(), PersonProperties.minAge(21));
System.out.println(adultMale.isMale());
// true
System.out.println(adultMale.getDateOfBirth());
// at least 21 years earlier
```

Creating related objects:

```java
Fairy fairy = Fairy.create();
Company company = fairy.company();
System.out.println(company.getName());
// Robuten Associates
System.out.println(company.getUrl());
// http://www.robuteniaassociates.com

Person salesman = fairy.person(PersonProperties.withCompany(company));
System.out.println(salesman.getFullName());
// Juan Camacho
System.out.println(salesman.getCompanyEmail());
// juan.camacho@robuteniaassociates.com
```

## Supported locales

| Locale | Language tag |
|--------|-------------|
| English (default) | `en` |
| Polish | `pl` |
| German | `de` |
| French | `fr` |
| Spanish | `es` |
| Swedish | `sv` |
| Chinese | `zh` |
| Georgian | `ka` |
| Italian | `it` |
| Brazilian Portuguese | `br` |
| Slovak | `sk` |

```java
Fairy enFairy = Fairy.create();
// Locale.ENGLISH is default
Fairy plFairy = Fairy.create(Locale.forLanguageTag("pl"));
// Polish version
Fairy brFairy = Fairy.create(Locale.forLanguageTag("br"));
// Brazilian version
```

## Unique values

```java
UniqueFairy unique = fairy.unique();
Person p1 = unique.person();  // unique by email
Person p2 = unique.person();  // different email than p1
Company c = unique.company(); // unique by name
```

For custom uniqueness keys:

```java
UniqueEnforcer<Person> unique = UniqueEnforcer.of(fairy::person, Person::getFullName);
Person p = unique.next();
```

## Thread safety

`Fairy` object should not be used concurrently by multiple threads. It is recommended to create `Fairy` instance for each thread.

Some methods are not thread-safe when multiple threads share the same `Fairy` object. For other methods it is still recommended to create a separate `Fairy` object, because `Random` object utilized underneath does not perform well when used concurrently by multiple threads.

## Other samples

Look into [code samples](https://github.com/SkillPanel/jfairy/tree/master/src/test/groovy/snippets/)

## Building

This project can be built using maven command:

    ./mvnw install
