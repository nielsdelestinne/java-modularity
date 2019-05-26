# JPMS

From the book: Java 9 Modularity (Sander Mak & Paul Bakker)

## Commands

- Compile a multimodule project: `javac -d out --module-source-path src -m easytext.cli
- Run the application: `java --module-path out --module easytext.cli/javamodularity.easytext.cli.Main`