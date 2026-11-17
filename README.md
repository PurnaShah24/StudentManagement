# Student Management System

A simple console program for managing students. It uses only Java 17 or later and keeps student records in an `ArrayList` while the program is running.

Each student has an integer ID, name, email, and course. The menu can add, view, search, update, and delete students. It prevents duplicate IDs and asks again when a text field is empty.

## Compile and Run

Open PowerShell in the project folder and run:

```powershell
New-Item -ItemType Directory -Force out/app | Out-Null
javac --release 17 -d out/app src/main/java/com/example/studentmanagement/model/Student.java src/main/java/com/example/studentmanagement/Main.java
java -cp out/app com.example.studentmanagement.Main
```

The `javac` command compiles the two Java files into `out`. The `java` command starts the menu. If `javac` or `java` is not recognized, install a JDK and add its `bin` folder to `PATH`.

## Create and Run a JAR

After compiling, create an executable JAR from PowerShell:

```powershell
if (Test-Path out/student-management-system.jar) { Remove-Item out/student-management-system.jar }
jar --create --file out/student-management-system.jar --main-class com.example.studentmanagement.Main -C out/app .
java -jar out/student-management-system.jar
```

The `jar` command packages the compiled classes. The `--main-class` option tells Java which class starts the program. The JDK's `bin` folder must be on `PATH` to use the `jar` command.

## GitFlow Basics

These Git commands are examples for you to run; no Git commands are run automatically. Replace `<USERNAME>` and `<REPOSITORY>` with your GitHub username and repository name.

### 1. Initialize Git

`git init` creates a local Git repository in the project folder.

### 2. Create the `main` branch

`git branch -M main` names the current branch `main`. This branch holds finished versions of the project.

### 3. Connect the GitHub repository

`git remote add origin https://github.com/<USERNAME>/<REPOSITORY>.git` saves your GitHub repository address under the short name `origin`.

### 4. Commit and push `main`

`git add .` stages the project files for saving.

`git commit -m "Initial commit"` saves the staged files as the first commit.

`git push -u origin main` uploads `main` to GitHub and remembers where future pushes should go.

### 5. Create the `develop` branch

`git switch -c develop` creates and switches to `develop`, where features are combined before a release.

`git push -u origin develop` uploads `develop` to GitHub and sets its upstream branch.

### 6. Create a feature branch

`git switch develop` switches to the integration branch.

`git pull origin develop` downloads and applies the latest changes from GitHub.

`git switch -c feature/student-search` creates a separate branch for the student-search feature.

### 7. Add, commit, and push feature changes

`git add .` stages the changes you made for this feature.

`git commit -m "Add student search"` saves those staged changes in a commit.

`git push -u origin feature/student-search` uploads the feature branch to GitHub.

### 8. Merge the feature into `develop`

`git switch develop` switches back to the integration branch.

`git pull origin develop` gets the latest shared changes before merging.

`git merge --no-ff feature/student-search` merges the feature into `develop` and keeps a separate merge record.

`git push origin develop` uploads the updated `develop` branch.

### 9. Create a release branch

`git switch develop` selects the branch containing the features for the next version.

`git pull origin develop` updates it from GitHub.

`git switch -c release/1.0.0` creates a branch for final checks on version 1.0.0.

`git push -u origin release/1.0.0` publishes the release branch on GitHub.

### 10. Merge the release into `main` and `develop`

`git switch main` selects the production branch.

`git pull origin main` updates it before the release merge.

`git merge --no-ff release/1.0.0` merges the release into `main`.

`git push origin main` uploads the released version.

`git switch develop` switches back to the integration branch.

`git pull origin develop` gets its latest shared changes.

`git merge --no-ff release/1.0.0` brings any release fixes back into `develop`.

`git push origin develop` uploads the updated integration branch.