# Git: Pull vs Fetch vs Clone, and Branch Management

## 🧩 1️⃣ Difference Between `git pull`, `git fetch`, and `git clone`

| Command | Purpose | When to Use | Key Behavior |
|----------|----------|--------------|----------------|
| **`git clone`** | Copies an **entire remote repository** (including history, branches, and files) to your local machine. | When starting to work on an existing project hosted remotely (like GitHub). | Creates a **new local repository** connected to the remote (`origin`). |
| **`git fetch`** | Downloads updates (new commits, branches, tags) from the remote repository **without merging** them into your current branch. | When you want to **see what’s changed remotely** before bringing it into your local branch. | Updates the remote-tracking branches (e.g., `origin/main`) but does **not** change your files. |
| **`git pull`** | Downloads updates **and automatically merges** them into your current branch. | When you’re ready to bring remote changes into your working branch. | Internally performs: `git fetch` + `git merge`. |

**Example:**
```bash
git clone https://github.com/user/project.git   # download full repo
git fetch                                       # see what’s new remotely
git pull                                        # update local codebase
```

---

## 🧩 2️⃣ Creating a New Branch

A branch allows you to work on features independently.

### Syntax
```bash
git branch <branch-name>
```

### Example
```bash
git branch feature/login-ui
```

This creates a branch named `feature/login-ui` but **does not switch to it yet**.

---

## 🧩 3️⃣ Switching Between Branches

To move from one branch to another:

### Old Syntax
```bash
git checkout <branch-name>
```

### Newer & Recommended Syntax
```bash
git switch <branch-name>
```

### Example
```bash
git switch feature/login-ui
```

If you want to create a new branch and switch to it immediately:
```bash
git switch -c feature/payment-api
```

---

## 🧩 4️⃣ List All Branches

```bash
git branch
```

Output example:
```
* main
  feature/login-ui
  feature/payment-api
```
The branch marked with `*` is your current working branch.

---

## 🧩 5️⃣ Delete a Branch

Once your branch is merged and no longer needed:

### Delete Local Branch
```bash
git branch -d feature/login-ui
```

### Force Delete (if not merged yet)
```bash
git branch -D feature/login-ui
```

### Delete Remote Branch
```bash
git push origin --delete feature/login-ui
```

---

## 🧩 6️⃣ Merging Branches

Once your feature is ready:

```bash
git switch main
git pull                # make sure main is updated
git merge feature/login-ui
git push
```

If conflicts occur, Git will highlight them — fix manually, then:
```bash
git add .
git commit
git push
```

---

## 🧩 7️⃣ Real-World Example (Step by Step)

```bash
# Step 1: Clone the repository
git clone https://github.com/ittechgenie/sample-project.git
cd sample-project

# Step 2: Create and switch to a new branch
git switch -c feature/add-contact-form

# Step 3: Make changes, stage, and commit
git add .
git commit -m "Add contact form page"

# Step 4: Push new branch to remote
git push -u origin feature/add-contact-form

# Step 5: Merge after review
git switch main
git pull
git merge feature/add-contact-form
git push
```

---

## 🧩 8️⃣ Summary Table

| Operation | Command | Description |
|------------|----------|-------------|
| Clone repo | `git clone <url>` | Create a copy of remote repo locally |
| Fetch updates | `git fetch` | Download updates without applying them |
| Pull updates | `git pull` | Download & merge updates into current branch |
| Create branch | `git branch <name>` | Create new branch |
| Switch branch | `git switch <name>` | Move to another branch |
| Create + switch | `git switch -c <name>` | Create and move to new branch |
| List branches | `git branch` | Show all branches |
| Merge branches | `git merge <branch>` | Combine changes from one branch into another |
| Delete branch | `git branch -d <name>` | Remove local branch |
| Delete remote branch | `git push origin --delete <name>` | Remove branch from remote |

---

**Trainer Tip:**  
Always name branches descriptively — e.g., `feature/user-login`, `bugfix/api-timeout`, `hotfix/payment-bug`.  
It helps teams quickly identify the purpose of work.

---
