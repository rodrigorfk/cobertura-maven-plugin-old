cobertura-maven-plugin
======================

This is a fork of cobertura-maven-plugin, this repository is intended to be used on some efforts to make cobertura plugin work properly on maven multi module projects.

### Original Code
You can find the original code in the following link: [codehaus svn] (http://svn.codehaus.org/mojo/trunk/mojo/cobertura-maven-plugin).
The import revision is 19761.

### Running aggregated reports
The plugin in this repository contains a new aggregated-report Mojo, this new Mojo generates a correct aggregated report of all modules in the maven reactor process.

To generate the report using this Mojo, issue the following command: `mvn cobertura:clean cobertura:instrument test cobertura:aggregate-report`
