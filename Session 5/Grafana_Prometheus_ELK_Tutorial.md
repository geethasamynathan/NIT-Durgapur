# 📊 Monitoring and Logging Stack – Grafana, Prometheus & ELK

**Purpose:** Modern DevOps monitoring and observability for system health, metrics, and logs.

---

## 🌐 Overview

| Tool | Category | Purpose | Works With |
|------|-----------|----------|------------|
| **Prometheus** | Monitoring | Collects and stores metrics data from applications & systems | Node Exporter, cAdvisor, APIs |
| **Grafana** | Visualization | Displays dashboards and alerts using Prometheus or ELK data | Prometheus, Elasticsearch, InfluxDB |
| **ELK Stack** | Centralized Logging | Collects, processes & visualizes log data | Applications, Servers, Containers |

---

## ⚙️ 1. Prometheus – Monitoring System

### 🔍 What is Prometheus?
Prometheus is an **open-source monitoring and alerting toolkit** built by SoundCloud and now part of the **Cloud Native Computing Foundation (CNCF)**.  
It collects metrics from **targets** (like apps, servers, containers) at given intervals and stores them in a **time-series database**.

### 💡 Why Use Prometheus?
- Auto-scrapes metrics from system endpoints (HTTP `/metrics`)
- Alerting with **Alertmanager**
- Works great with **Grafana** dashboards
- **Free** and **easy to use locally**

---

### 🧰 Installation (Local Machine)

#### 🪟 Windows
1. Download from: [https://prometheus.io/download/](https://prometheus.io/download/)
2. Extract zip → open PowerShell → navigate to folder  
   ```bash
   prometheus.exe --config.file=prometheus.yml
   ```
3. Open browser → [http://localhost:9090](http://localhost:9090)

#### 🐧 Linux / Mac
```bash
wget https://github.com/prometheus/prometheus/releases/download/v2.52.0/prometheus-2.52.0.linux-amd64.tar.gz
tar -xvf prometheus-2.52.0.linux-amd64.tar.gz
cd prometheus-2.52.0.linux-amd64
./prometheus --config.file=prometheus.yml
```

---

### 🧩 Example Configuration – `prometheus.yml`
```yaml
global:
  scrape_interval: 5s  # Collect metrics every 5 seconds

scrape_configs:
  - job_name: 'prometheus'
    static_configs:
      - targets: ['localhost:9090']

  - job_name: 'node_exporter'
    static_configs:
      - targets: ['localhost:9100']
```

---

### 📦 Add Node Exporter (to monitor system metrics)

```bash
wget https://github.com/prometheus/node_exporter/releases/download/v1.8.0/node_exporter-1.8.0.linux-amd64.tar.gz
tar -xvf node_exporter-1.8.0.linux-amd64.tar.gz
cd node_exporter-1.8.0.linux-amd64
./node_exporter
```

✅ Visit [http://localhost:9100/metrics](http://localhost:9100/metrics) — system CPU, RAM, Disk metrics are shown.

✅ Now Prometheus scrapes these metrics every 5s.

---

### 🧠 Real-World Use Case
> “Monitor a web server’s CPU, memory, and uptime using Prometheus and visualize it on Grafana.”

- Prometheus collects metrics from Node Exporter.
- Alerts can be triggered if CPU usage > 80%.
- Grafana displays charts & triggers email/SMS alerts.

---

## 📈 2. Grafana – Visualization Layer

### 🔍 What is Grafana?
Grafana is an **open-source visualization tool** that connects to various data sources (Prometheus, Elasticsearch, MySQL, etc.) and creates **interactive dashboards**.

---

### 💡 Why Use Grafana?
- Converts metrics into rich charts, tables, and graphs
- Custom alerting (email, Slack, Teams)
- Connects with Prometheus or ELK
- Free and local installation supported

---

### 🧰 Installation (Local)

#### Using Docker
```bash
docker run -d -p 3000:3000 --name=grafana grafana/grafana
```
👉 Access: [http://localhost:3000](http://localhost:3000)  
Default Login: **admin / admin**

---

### 🔗 Connect Grafana to Prometheus

1. Go to **Settings → Data Sources → Add Data Source**
2. Choose **Prometheus**
3. Set URL → `http://localhost:9090`
4. Click **Save & Test**

---

### 📊 Create a Dashboard

1. Click **Create → Dashboard**
2. Add a new **Panel**
3. Query example:
   ```
   node_cpu_seconds_total
   ```
4. Apply visualization → e.g., Graph or Gauge

✅ Now you’ll see live system metrics from Prometheus.

---

### 🧠 Real-World Use Case
> “Create an infrastructure monitoring dashboard for all Linux servers showing CPU, Memory, Disk, and Network usage.”

- Prometheus scrapes Node Exporter metrics.
- Grafana dashboard visualizes these over time.
- Email/SMS alert when a metric crosses threshold.

---

## 🪵 3. ELK Stack (Elasticsearch, Logstash, Kibana)

### 🔍 What is ELK?
ELK = **Elasticsearch + Logstash + Kibana**  
It’s a full-fledged **log management and analytics stack**.

| Component | Purpose |
|------------|----------|
| **Elasticsearch** | Stores log data (searchable database) |
| **Logstash** | Collects, filters, and transforms log data |
| **Kibana** | Visualizes log data in dashboards |

---

### 💡 Why Use ELK?
- Centralized log analysis
- Real-time searching and filtering
- Correlate application and infrastructure logs
- Free and open-source (basic tier)

---

### 🧰 Installation with Docker (Simplest Local Setup)
Create a file named **`docker-compose.yml`**

```yaml
version: '3.7'
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.14.0
    container_name: elasticsearch
    environment:
      - discovery.type=single-node
      - xpack.security.enabled=false
    ports:
      - "9200:9200"

  logstash:
    image: docker.elastic.co/logstash/logstash:8.14.0
    container_name: logstash
    ports:
      - "5044:5044"
    volumes:
      - ./logstash.conf:/usr/share/logstash/pipeline/logstash.conf

  kibana:
    image: docker.elastic.co/kibana/kibana:8.14.0
    container_name: kibana
    ports:
      - "5601:5601"
```

---

### 🧩 Logstash Configuration – `logstash.conf`
```conf
input {
  file {
    path => "/var/log/syslog"
    start_position => "beginning"
  }
}

filter {
  grok {
    match => { "message" => "%{SYSLOGTIMESTAMP:timestamp} %{GREEDYDATA:log}" }
  }
}

output {
  elasticsearch {
    hosts => ["http://elasticsearch:9200"]
    index => "system-logs"
  }
  stdout { codec => rubydebug }
}
```

---

### ▶️ Run Stack
```bash
docker-compose up -d
```

- Elasticsearch → [http://localhost:9200](http://localhost:9200)  
- Kibana → [http://localhost:5601](http://localhost:5601)

---

### 📊 In Kibana
1. Open **Discover** → Choose index pattern: `system-logs*`
2. View incoming log data in real-time.
3. Create dashboard → visualize log trends, errors, etc.

---

### 🧠 Real-World Use Case
> “Centralize all application logs (from Node.js, Java, Python apps) in ELK for debugging production issues.”

- Applications send logs to Logstash (via Filebeat)
- Logstash parses and enriches logs
- Elasticsearch stores them for fast search
- Kibana visualizes errors, warnings, performance

---

## 🔄 Combine All Three – Observability Stack

| Layer | Tool | Function |
|-------|------|-----------|
| Metrics | Prometheus | Collects metrics like CPU, memory, request rate |
| Visualization | Grafana | Displays Prometheus & Elasticsearch dashboards |
| Logs | ELK | Centralized logging and error analytics |

---

### 🧱 Example Architecture Diagram

```
   ┌──────────────────┐
   │   Application     │
   │ (Node.js, Java)   │
   └───────┬───────────┘
           │
           ▼
 ┌────────────────────┐
 │  Logstash + Beats  │ ← (Collects app logs)
 └────────┬───────────┘
          ▼
 ┌────────────────────┐
 │  Elasticsearch     │ ← (Stores logs)
 └────────┬───────────┘
          ▼
 ┌────────────────────┐
 │  Kibana Dashboard  │ ← (Visualize logs)
 └────────────────────┘

 ┌────────────────────┐
 │ Node Exporter      │ ← (System metrics)
 └────────┬───────────┘
          ▼
 ┌────────────────────┐
 │ Prometheus Server  │ ← (Scrapes metrics)
 └────────┬───────────┘
          ▼
 ┌────────────────────┐
 │   Grafana          │ ← (Visual + Alerts)
 └────────────────────┘
```

---

## 🧩 Practical Mini Project – Local System Monitoring

| Component | Tool | Setup Summary |
|------------|------|----------------|
| System Metrics | Node Exporter + Prometheus | Collects CPU, RAM usage |
| Visualization | Grafana | Shows metrics graphs |
| Logs | ELK Stack | Collects system/app logs |
| Outcome | Full observability locally |

---

## 🪙 Cost & Licensing
| Tool | Cost | License |
|------|------|----------|
| Prometheus | Free | Apache 2.0 |
| Grafana | Free / Paid (Enterprise) | AGPL v3 |
| ELK Stack | Free (Basic tier) | Elastic License |

All are **open-source** and can run **fully on your laptop** with Docker.

---

## 🧠 Summary

| Feature | Prometheus | Grafana | ELK |
|----------|-------------|----------|-----|
| Focus | Metrics | Visualization | Logs |
| Data Type | Time-series | Graphs/Dashboards | Textual logs |
| Storage | Built-in TSDB | N/A | Elasticsearch |
| Visualization | Basic | Rich UI | Kibana |
| Alerting | Yes (Alertmanager) | Yes | Yes |
| Open Source | ✅ | ✅ | ✅ |

---

## 🧪 Demo Command Summary
| Task | Command |
|------|----------|
| Start Prometheus | `./prometheus --config.file=prometheus.yml` |
| Start Node Exporter | `./node_exporter` |
| Start Grafana | `docker run -d -p 3000:3000 grafana/grafana` |
| Start ELK Stack | `docker-compose up -d` |
| View Grafana | [http://localhost:3000](http://localhost:3000) |
| View Prometheus | [http://localhost:9090](http://localhost:9090) |
| View Kibana | [http://localhost:5601](http://localhost:5601) |

---
