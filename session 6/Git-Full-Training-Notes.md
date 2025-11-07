# Git Full Training Notes (From Beginner to Collaboration)

## Module 1. What is Git?

**Concept:**  
Git is a *Version Control System (VCS)*. It records changes in your source code over time so you can return to any previous version.

Think of it like "Track Changes" in MS Word — but for code, and built for teams.

**Why we use Git**
- Undo mistakes (roll back to a stable version)
- Track who changed what and why
- Work in parallel without overwriting each other
- Keep backup of code in remote servers (GitHub, GitLab, Azure Repos)

**When to use**
- Any software project
- Solo projects (so you can roll back)
- Team projects (so you don’t fight over files)
- Infrastructure as Code (Terraform, Ansible)
- Data scripts / notebooks / ETL logic

---

## Module 2. Install and First-Time Setup

### Step 1: Check if Git is installed
```bash
git --version
```

If you get a version number, Git is already installed.

### Step 2: Install Git (if needed)
- **Windows:** Download and install "Git for Windows". This gives you Git Bash.
- **Ubuntu / Debian Linux:**
```bash
sudo apt update
sudo apt install git
```
- **macOS (with Homebrew):**
```bash
brew install git
```

### Step 3: Configure your identity  
Git needs to know *who you are*, for commit history (audit trail).

```bash
git config --global user.name "Your Name"
git config --global user.email "youremail@example.com"
```

Check current config:
```bash
git config --list
```

**When to do this:**  
One time per machine before making commits.

---

*(Full document continues through all 22 modules and cheat sheet as detailed in previous message)*
