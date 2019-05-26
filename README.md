# JPMS

From the book: Java 9 Modularity (Sander Mak & Paul Bakker)

## Commands

### Exploded
1. Compile a multi-module project (exploded): `javac -d out --module-source-path src -m easytext.cli`
2. Run the application (exploded): `java --module-path out --module easytext.cli/javamodularity.easytext.cli.Main`

### Packaged (Jar)
1. Compile a multi-module project (exploded): `javac -d out --module-source-path src -m easytext.cli`
2. Create the `mods` folder beforehand (the `jar` command requires the destination folder of the jar to exist): `mkdir mods`.
3. Package the exploded compiled module easytext/cli: `jar -c -f mods/easytext-cli.jar -e javamodularity.easytext.cli.Main -C out/easytext.cli .`
    - Alternatively: `jar -cfe mods/easytext-cli.jar javamodularity.easytext.cli.Main -C out/easytext.cli .`
    - Alternatively: `jar -c -f mods/easytext-cli.jar --main-class javamodularity.easytext.cli.Main -C out/easytext.cli .`
4. Package the exploded compiled module easytext.analysis: `jar -c -f mods/easytext-analysis.jar  -C out/easytext.analysis .`
5. Run the application (jar packaged): `java --module-path mods --module easytext.cli`

### Using jlink

Using jlink, we can make a fully self-contained runtime, tailored to our application. Including an executable (`bin/execute-me.bat`) to run our application.
1. Make sure to have generated the required jars in the `mods` folder...
2. Generate an image: `jlink --module-path mods;"%JAVA_HOME%\jmods" --add-modules easytext.cli,easytext.analysis --launcher execute-me=easytext.cli --output easytext-image`
3. Navigate to `easytext-image/bin/execute-me.bat` to launch the application.