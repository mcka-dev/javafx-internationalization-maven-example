# Hello JavaFX multiple-language and Maven (Example Project)
Simple "Hello, world!" example showing a ready to roll JavaFX project using multiple-language support is for those who need some more __exotic__ language (controls_be_BY.properties, controls_ru.properties etc.). You can create your own based on examples (controls_de.properties, controls_es.properties, controls_fr.properties, controls_it.properties, controls_ja.properties, controls_ko.properties, 
controls_pt_BR.properties, controls_sv.properties, controls_zh_CN.properties, controls_zh_TW.properties, controls-nt.properties) found in com/sun/javafx/scene/control/skin/resources/ in `jxfrt.jar` provided with JRE. 
This can be downloaded and used as a starter template for your own Maven JavaFX projects.

## Get the Example Code

Download a ZIP of the source code (hit the "ZIP" button above) and extract anywhere on your local directory.

## Build the Project 

Use the package command to build your project. If you are new to Maven, see 
http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

```
    mvn clean package
```

Once this command completes successfully you will find an executable JAR at: 

```
    {project.home}/target/javafx-internationalization-maven-example.jar
```

## Make your own changes 

To edit the source code you can just open the POM file (i.e. pom.xml) in the base directory of the project in most
popular IDEs (IntelliJ IDEA, NetBeans, Eclipse).

This example project is provided as an example and as a base template for your own Maven and JavaFX projects. You are
free to take the example project and change it as much as you like. You can delete everything that is there and start
from scratch, or you can add to what's there. 

You definitely should: 

* Change the groupId in the pom.xml to use `com.yourcompany` instead of `com.krasutski`
* Change the artifactId in the pom.xml to be `your-project-name` instead of `javafx-internationalization-maven-example`
* Change the base package being use for the Java files to be `com.yourcompany` instead of `com.krasutski`
* Change the icon in folder `src/main/resources/icons`
* Add more exotic languages ​​to the folder `src/main/resources/com/sun/javafx/scene/control/skin/resources` of this project

If you don't have a company name, use a nickname or working name for yourself, e.g. `com.yourname`.

## Screenshots

Belarusian language:
<a href="https://github.com/mcka-dev/javafx-internationalization-maven-example/blob/master/screenshots/be_BY.png"><img src="https://github.com/mcka-dev/javafx-internationalization-maven-example/blob/master/screenshots/be_BY.png" alt="JavaFX: be-BY" title="JavaFX: be-BY"></a>

Russian language:
<a href="https://github.com/mcka-dev/javafx-internationalization-maven-example/blob/master/screenshots/ru_RU.png"><img src="https://github.com/mcka-dev/javafx-internationalization-maven-example/blob/master/screenshots/ru_RU.png" alt="JavaFX: ru-RU" title="JavaFX: ru-RU"></a>

## Support

Send me your samples exotic languages of `controls_*.properties` and I'll add them to this project.

## License

Code released under the <a href="https://github.com/mcka-dev/javafx-internationalization-maven-example/blob/master/LICENSE">MIT License</a>
