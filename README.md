# AEM project template

This is a project template for AEM-based applications. It is intended as a best-practice set of examples as well as a potential starting point to develop your own functionality.

## Modules

The main parts of the template are:

* core: Java bundle containing all core functionality like OSGi service, sling Model and third party jars
* ui.apps: contains the /apps components, template and dialog
	- Created component that displays expected result and can be customized to show pets for female or male or     	both
	- Also can customize pet type to show result as per petType- default being cat
* ui.content: contains page that has component displaying result using the components from the ui.apps
 Url : http://localhost:<port>/content/codingTest/pets.html

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM with  

    mvn clean install -PautoInstallPackage
    

to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

## Testing

There are three levels of testing contained in the project:

* unit test in core: this show-cases classic unit testing of the code contained in the bundle. To test, execute:

    mvn clean test

