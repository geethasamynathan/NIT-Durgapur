# 🧭 Trello End-to-End Project Dashboard (Step-by-Step Tutorial)

## 🎯 Goal
We’ll create a **Software Development Project Dashboard** in Trello that shows:
- Project Title  
- Task details (with subtasks & assignments)  
- Hours logged & progress tracking  
- Sprint grouping  
- Completed vs In-Progress tasks  

---

## 🧩 Step 1: Create a Trello Board

1. Go to 👉 [https://trello.com](https://trello.com)
2. Click **Create new board**
3. Enter:
   - **Board Title:** *“E-Commerce Web App Development”*
   - **Workspace:** Choose your workspace (e.g., ItTechGenie Projects)
   - **Visibility:** Private / Workspace Visible
   - Choose a background color or image  
4. Click **Create Board**

🖼️ *Result:* A blank board opens with default lists: *To Do*, *Doing*, *Done*  

---

## 🧱 Step 2: Rename Lists to Match Agile Flow

Click on each list name and rename as:

1. **Product Backlog**
2. **Sprint 1 – In Progress**
3. **Sprint 1 – Testing**
4. **Sprint 1 – Completed**
5. **Sprint 2 – Planning**

💡 Tip: Lists = Columns = Stages in your project flow.

---

## 🗂️ Step 3: Add Cards for Each Task

Each **card** = One **task or feature**.

Click **“+ Add a card”** under *Product Backlog* and add:

| Task Title | Description (Short) |
|-------------|----------------------|
| 🧩 User Login Module | Design login form, backend validation, and DB authentication |
| 🛒 Product Listing Page | Display products dynamically from API |
| 💳 Payment Gateway Integration | Integrate Razorpay for checkout |
| 🧠 Recommendation Engine | AI-based suggestions for customers |

After adding all, click **Add Card** ✅

---

## 🧾 Step 4: Add Detailed Information Inside a Card

Click on a card (e.g., *User Login Module*) to open the detailed view.

### 🧩 Step 4.1 — Add Description
In the **Description** box, write details:
> Create login form with email & password fields, validate credentials via backend API, and handle incorrect logins gracefully.

### 🧩 Step 4.2 — Add Checklist (Subtasks)
Click **Checklist → Add Checklist → Name it “Subtasks”**

Add items:
- [ ] Create Login Form UI  
- [ ] Connect API Endpoint  
- [ ] Validate Token  
- [ ] Store Auth Token in LocalStorage  
- [ ] Test with Mock Users  

💡 *Subtasks automatically create mini progress bars.*

### 🧩 Step 4.3 — Add Members
On the right panel → **Members → Select Team Members**
- Gopinath  
- Krishna  
- Meena  

### 🧩 Step 4.4 — Add Due Date
Click **Dates → Choose Start and Due Date**
> Example: Start: Nov 2, End: Nov 6, 2025

### 🧩 Step 4.5 — Add Labels (Priority)
Click **Labels → Create:**
- 🔴 High Priority  
- 🟡 Medium  
- 🟢 Low  

### 🧩 Step 4.6 — Add Custom Fields (Power-Up)
Enable Power-Up → **Custom Fields**  
Then add fields:

| Field Name | Type | Example |
|-------------|-------|----------|
| Log Hours | Number | 6 |
| Sprint | Dropdown | Sprint 1 |
| Status | Dropdown | In Progress |

💡 *You’ll now see “Log Hours: 6” inside the card.*

---

## ⚙️ Step 5: Organize Tasks by Sprint

### 🧠 Example:
- **Sprint 1:** Login, Product Listing, Payment Gateway  
- **Sprint 2:** Recommendation Engine, Analytics Dashboard  

Drag each card into the appropriate sprint list.

💡 *Visually separates current sprint tasks from future ones.*

---

## 🔄 Step 6: Track Progress

### 6.1 Move Cards Across Lists
As tasks progress:
- Move from *Product Backlog → Sprint 1 – In Progress → Sprint 1 – Testing → Sprint 1 – Completed*

### 6.2 Checklist Progress
Each card shows a mini progress bar (e.g., 3/5 subtasks complete).

### 6.3 Member Workload
Open board menu → **Dashboard View**
- See how many tasks each person has  
- Filter by member or sprint  

---

## 📅 Step 7: Add Time Tracking (Log Hours)

If using free version → use **Custom Field “Log Hours”** manually.

If using Power-Ups:
- Enable **Time Tracking Power-Up** like *Time Tracker by Planyway* or *Clockify*  
- Add inside card → Start Timer → Stop → Auto logs to card  

**Example:**
> Krishna logged 4 hrs, Gopinath logged 2 hrs → Total 6 hrs for the Login module.

---

## 🧠 Step 8: Enable Dashboards and Views

Click **Views → Dashboard**

You’ll see a chart:

| Metric | Data |
|--------|------|
| Total Tasks | 20 |
| Completed | 8 |
| In Progress | 6 |
| Not Started | 6 |

**Widgets:**
- Tasks by Sprint  
- Tasks by Member  
- Hours Logged  
- Completed %  

💡 Helps you see Sprint Burndown and member load visually.

---

## 🧩 Step 9: Use Automation (Butler)

Go to **Automation → Rules → Create Rule**

### Example 1:
> When a card is moved to “Sprint 1 – Completed”  
> → mark due date complete  
> → add label “✅ Done”  
> → send Slack notification to #dev-team  

### Example 2:
> Every Monday at 9 AM → create a new card “Sprint Review Meeting” in *Sprint 1 – In Progress*

---

## 🧮 Step 10: Sprint Summary & Reports

1. Go to **Dashboard View**
2. Click **Filter → Sprint 1**
3. Export report to CSV or screenshot chart  

**Sprint Summary Example:**

| Metric | Value |
|---------|--------|
| Total Tasks | 10 |
| Completed | 8 |
| In Progress | 2 |
| Hours Logged | 48 hrs |
| Sprint Duration | Nov 1 – Nov 15, 2025 |

---

## ✅ Final Result – Your Trello Dashboard

### Board Title: E-Commerce Web App Development

| Sprint List | Example Cards | Status |
|--------------|----------------|--------|
| Product Backlog | Collect requirements, Setup DB schema | Planned |
| Sprint 1 – In Progress | Login module, Product listing | Ongoing |
| Sprint 1 – Testing | Payment Gateway | Testing |
| Sprint 1 – Completed | Homepage design | Done |
| Sprint 2 – Planning | Recommendation Engine | Upcoming |

**Dashboards:**  
- Total tasks completed this sprint  
- Hours logged per member  
- Burndown chart per sprint  
- Automation for daily standups  

---

## 🧩 Optional Enhancements

| Feature | Power-Up / Add-on |
|----------|-------------------|
| Time tracking | Clockify, Planyway |
| Gantt Chart | BigPicture or Timeline View |
| Slack updates | Slack Power-Up |
| GitHub commits link | GitHub Power-Up |
| Sprint charts | Trello Dashboard View |

---

## 🧠 Quick Recap

| Step | Action | Outcome |
|------|---------|----------|
| 1 | Create Board | Project Space ready |
| 2 | Add Lists | Define workflow |
| 3 | Add Cards | Define tasks |
| 4 | Add Details | Descriptions, Members, Checklists |
| 5 | Assign Sprints | Group work |
| 6 | Track Progress | Visual updates |
| 7 | Log Hours | Measure productivity |
| 8 | Dashboards | Analytics view |
| 9 | Automation | Saves time |
| 10 | Sprint Review | Summary ready |
