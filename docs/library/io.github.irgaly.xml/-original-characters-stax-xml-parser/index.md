//[library](../../../index.md)/[io.github.irgaly.xml](../index.md)/[OriginalCharactersStaxXmlParser](index.md)

# OriginalCharactersStaxXmlParser

[jvm]\
class [OriginalCharactersStaxXmlParser](index.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), configure: (factory: WstxInputFactory) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?) : [Closeable](https://docs.oracle.com/javase/8/docs/api/java/io/Closeable.html)

preserve original characters XML StAX Parser

## Constructors

| | |
|---|---|
| [OriginalCharactersStaxXmlParser](-original-characters-stax-xml-parser.md) | [jvm]<br>fun [OriginalCharactersStaxXmlParser](-original-characters-stax-xml-parser.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), configure: (factory: WstxInputFactory) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [hasNext](has-next.md) | [jvm]<br>fun [hasNext](has-next.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [nextEvent](next-event.md) | [jvm]<br>fun [nextEvent](next-event.md)(): [XmlEvent](../-xml-event/index.md) |
| [peek](peek.md) | [jvm]<br>fun [peek](peek.md)(): XMLEvent2? |
