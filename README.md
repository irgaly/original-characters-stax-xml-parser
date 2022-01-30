# original-characters-stax-xml-parser

A Stax Parser Wrapper with original texts from input XML.

This library is useful to parse and modify XML, with preserving original characters and original XML
structures.

exmple: preserving spaces and indent tabs, don't extract `&#{unicode};`, don't replace `>`
with `&gt;`, don't replace XML empty tag...

This is a simple wrapper to [Woodstox](https://github.com/FasterXML/woodstox) Stax2 XML Parser.

## Usage

This library is published to Maven Central Repository.

Ensure `mavenCentral()` is declared.

`settings.gradle.kts`

```kotlin
dependencyResolutionManagement {
    repositories {
        //...
        mavenCentral()
    }
}
```

Add dependencies.

`build.gradle.kts`

```kotlin
dependencies {
  implementation("io.github.irgaly.xml:original-characters-stax:1.0.1")
}
```

Then use library!

## Class Documents

[There are KDoc references.](docs/index.md)

## OriginalCharactersStaxXmlParser class

OriginalCharactersStaxXml class sample.

This class is a simple wrapper class to Woodstox's WstxEventReader class.

```kotlin
val inputStream = File("input.xml").inputStream()
val parser = OriginalCharactersStaxXmlParser(inputStream)
while (parser.hasNext()) {
    val event = parser.nextEvent()
    println("original text:[${event.originalText}]")
}
parser.close() // parser closes inputStream too.
```

parser.nextEvent() returns XmlEvent, that has both of Stax original Event and XML original Text.

```kotlin
event.event // Stax2's XMLEvent2
event.originalText // Original XML's Texts
```

That sample code's input and output is below.

`input.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- header comment -->
<resources>
    <!-- comment1 -->
    <reference>&apos; &amp;</reference>
    <surrogate>&#x1F6AD;</surrogate>
    <empty></empty>
</resources>
<!-- footer comment -->
```

outputs

```shell
original text:[<?xml version="1.0" encoding="utf-8"?>]
original text:[
]
original text:[<!-- header comment -->]
original text:[
]
original text:[<resources>]
original text:[
    ]
original text:[<!-- comment1 -->]
original text:[
    ]
original text:[<reference>]
original text:[&apos; &amp;]
original text:[</reference>]
original text:[
    ]
original text:[<surrogate>]
original text:[&#x1F6AD;]
original text:[</surrogate>]
original text:[
    ]
original text:[<empty>]
original text:[</empty>]
original text:[
]
original text:[</resources>]
original text:[
]
original text:[<!-- footer comment -->]
original text:[]
```

## More documentation for Stax2

* [Github Woodstox](https://github.com/FasterXML/woodstox)
* Stax Configurations
    * [Stax1 Properties](https://cowtowncoder.medium.com/configuring-woodstox-xml-parser-basic-stax-properties-39bdf88c18ec)
    * [Stax2 Properties](https://cowtowncoder.medium.com/configuring-woodstox-xml-parser-stax2-properties-c80ef5a32ef1)
    * [Woodstox Properties](https://cowtowncoder.medium.com/configuring-woodstox-xml-parser-woodstox-specific-properties-1ce5030a5173)
