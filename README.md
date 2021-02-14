# Where2GO

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 11.2.0.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

FRONTEND Settings:
01) on visual studio code open folder --> choose folder where project should be in

02) type in without "" "sudo npm install -g @angular/cli" and "npm install --save-dev @angular-devkit/build-angular"

03) type in without "" "ng new Where2GO" --> Yes to Angular routing --> Choose CSS

04) Right click on "Where2GO" --> Choose "Open in integrated terminal"

05) type in without "" "ng add @angular/material" --> Choose custom --> y --> y

06) Start app with typing without "" "ng serve" --> on Webbrowser type in without "localhost:4200"

07) In Visual Studio Code Open Where2GO-->src-->app right click on "app" than "New Folder" name it without "" "components"

08) Right click on "components" than "copy path"

09) Right click on "Where2GO" --> Choose "Open in integrated terminal"

10) in the new terminal type in without "" "cd " and paste the copied path

11) type in without "" "ng generate @angular/material:navigation navigation-site"

12) type in without "" "ng generate @angular/material:dashboard map-result"

13) type in without "" "ng generate component new-search"


BACKEND Settings:

1) add json-lib as dependency in IntelliJ IDEA CE, if the dependency isn't in the project
    1.1) on macOS (similar way on Windows) click on "File" on the top than "Project Structure"

    1.2) below "Project Settings" click on "Modules"

    1.3) in "Modules" you have below "Name: " --> "Sources", "Paths" and "Dependencies"

    1.4) click on "Dependencies" than on the bottom you can find "+", press on it

    1.5) choose option "1 JARs or directories..." 
    
    1.6a) go in the directory of the project Where2GO --> backend --> libs, and choose java-json.jar or 1.6b)

    1.6b) download the file from "https://sourceforge.net/projects/json-lib/", after downloading it
    
        1.6b.1) create a folder in the project directory Where2GO --> backend, create a folder libs and paste the downloaded file inside
        1.6b.2) repeat the step 1.6a)
