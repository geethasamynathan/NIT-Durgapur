# ☁️ Jenkins – Complete Tutorial with Core Java Example

## 🔹 1️⃣ What is Jenkins?
Jenkins is an open-source automation server for building, testing, and deploying applications. It’s a cornerstone of CI/CD pipelines.

### 🧠 Key Features
- Free & open-source  
- 1800+ plugins (Git, Maven, Docker, AWS)  
- Runs on all OS (Windows, macOS, Linux)  
- Web interface (http://localhost:8080)

---

## 🔹 2️⃣ Why Jenkins?
| Traditional | With Jenkins |
|--------------|--------------|
| Manual build | Automated build |
| Inconsistent | Consistent environment |
| Hard to integrate | Plugin-based |
| Delayed feedback | Continuous feedback |

**Example:**  
On GitHub commit → Jenkins fetches code → compiles → runs tests → deploys.

---

## 🔹 3️⃣ Installation Steps

### 🖥️ Requirements
- Java 11+  
- 4GB RAM

### ⚙️ Steps
1. **Install Java**
   ```bash
   java -version
   ```
2. **Download Jenkins**
   From [https://www.jenkins.io/download](https://www.jenkins.io/download)
3. **Run Jenkins**
   ```bash
   java -jar jenkins.war
   ```
   Access: [http://localhost:8080](http://localhost:8080)
4. **Unlock Jenkins**
   Copy key from:
   ```
   C:\Program Files\Jenkins\secrets\initialAdminPassword
   ```
5. **Install Plugins** – select *suggested plugins*  
6. **Create Admin User**  
7. Jenkins is ready 🎉

---

## 🔹 4️⃣ Folder Structure
| Path | Description |
|------|--------------|
| `/var/lib/jenkins` | Home directory |
| `/var/lib/jenkins/jobs` | Job configs |
| `/var/lib/jenkins/workspace` | Build workspace |

---

## 🔹 5️⃣ Example: Core Java Program Build in Jenkins

### 💡 Objective
Automate the build of a simple Java program using Jenkins + Maven.

### 🧰 Tools
- Java JDK 17  
- Maven  
- GitHub  
- Jenkins

---

### Step 1 – Java Code
`HelloWorld.java`
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("✅ Hello from Jenkins Build Automation!");
    }
}
```

---

### Step 2 – Maven POM
`pom.xml`
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.ittechgenie</groupId>
    <artifactId>JenkinsJavaDemo</artifactId>
    <version>1.0</version>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

### Step 3 – Push to GitHub
```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/yourusername/JenkinsJavaDemo.git
git push -u origin main
```

---

### Step 4 – Create Jenkins Job
1. Dashboard → **New Item → Freestyle Project**  
2. Name: `Java-Build-Demo`  
3. Source: Git → Repo URL  
4. Build trigger: *GitHub hook trigger for GITScm polling*  
5. Build step: *Invoke top-level Maven targets*  
   - Goals: `clean compile exec:java`  
6. Save & Build

**Output:**
```
[INFO] BUILD SUCCESS
✅ Hello from Jenkins Build Automation!
```

---

## 🔹 6️⃣ Real-World CI/CD Extension
- Jenkins pulls code → compiles → runs JUnit → builds JAR → deploys to AWS/Docker.

---

## 🔹 7️⃣ Jenkins in Real Projects
| Use Case | Jenkins Role |
|-----------|---------------|
| Microservices | Build & deploy containers |
| Data Engineering | Automate ETL/Spark jobs |
| ML Projects | Train & deploy models |
| Java Apps | Build → Test → Deploy |

---

## ✅ Summary
| Concept | Description |
|----------|--------------|
| Jenkins | CI/CD automation tool |
| Language | Java |
| Purpose | Build, test, deploy automation |
| Example | Java build demo |
| Integrations | Git, Maven, Docker, AWS |
