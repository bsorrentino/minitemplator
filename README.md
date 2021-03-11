## MiniTemplator

MiniTemplator is a java compact template engine.


><a href="http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22minitemplator-repackaged%22"><img src="https://img.shields.io/maven-central/v/org.bsc.util/minitemplator-repackaged.svg">


## Features

Simple syntax for template variables and blocks.
Blocks can be nested.
Compact, well-documented source code. A single code module.
Documentation and sample programs available.
Open Source, licensed under the [GNU LGPL](http://www.gnu.org/licenses/lgpl.html) & [EPL](http://www.eclipse.org/legal). It may be used freely, even for commercial projects ([Details](http://en.wikipedia.org/wiki/LGPL)).
Available as maven dependency from [CENTRAL](http://search.maven.org/#artifactdetails%7Corg.bsc.util%7Cminitemplator-repackaged%7C1.2%7Cmaven-plugin)

```xml
<dependency>
    <groupId>org.bsc.util</groupId>
    <artifactId>minitemplator-repackaged</artifactId>
    <version>_last_version_</version>
</dependency>
```
**Example**
```java

String templateFileName = "src/test/resources/template.txt";

File f = new File(templateFileName);

MiniTemplator t =
    MiniTemplator.builder()
        .setSkipUndefinedVars(true)
        .build(f.toURI().toURL());

t.setVariable("var1", "test");

String result = t.generateOutput();

```


## What is a Template Engine?

A template engine is a software module which is used to generate HTML pages (or other text files). The layout of a HTML page is defined within a template file, which can be designed by using a standard HTML editor like FrontPage. At run-time, the application program instructs the template engine to load the template, fill in variable values, repeat blocks and produce the final HTML page.

## Why use a Template Engine?

The advantage of using a template engine, instead of embedding program code and HTML code, is:

 * Program code and web page layout are separated and can be designed and modified independently.
 * A software developer and a web page designer can work together without interfering in each others work. Responsibilities can be split.
 * After the program has been finished, the page layout can be modified at a later time, without having to modify the program code.
 * Templates are useful when web pages will be translated, and multiple languages must be supported by the same program.

## Why use MiniTemplator?

 * There are other template engines (like Velocity, WebMacro or Smarty) which are huge and use complex template syntaxes. These template syntaxes are so complex that they are almost like new programming languages. MiniTemplator however uses a very simple template syntax. All processing (loops, if-then-else logic) and variable formatting is done in application program code (Java/PHP/VB), which leads to better separation of layout and code, and no new complex syntax has to be learned.
 * There are simple template engines which do not provide elementary features (like nested blocks, loading the template from a string, or storing the output into a string variable), or are slow. MiniTemplator provides these elementary features and is fast, because the template is only parsed once (at the time it is loaded).
 * MiniTemplator provides the features to build professional web applications, and it is compact and fits within a single code module.

### Syntax

A simple syntax is used to define variables and blocks within the template. This syntax is compatible with HTML editors like FrontPage, but it can also be used for non-HTML files.

### Variables:

```
${VariableName}
```

### Escape Variables (ignore)

```
\${VariableName}
```
result will be
```
${VariableName}
```
### Blocks:

```
<!-- $BeginBlock BlockName -->
 ... block content ...
<!-- $EndBlock BlockName -->
```

### Include a subtemplate:

```
<!-- $Include RelativeFileName -->
```
