# KdTree

A **2D Kd-Tree** implementation in Java for storing points in the unit square and efficiently supporting **range search** and **nearest neighbor queries**. This project also includes visualization tools to help understand Kd-Tree operations.

---

## Features

- **Insert points** into a 2D Kd-Tree.
- **Check point existence** with `contains`.
- **Range search**: Find all points within a given rectangle.
- **Nearest neighbor search**: Find the closest point to a query point.
- **Draw points and division lines** using `StdDraw`.
- **Efficient splitting**: Alternates between vertical and horizontal division lines.
- Includes support files for **visualizing the tree and queries**.

---

## Files

- `KdTree.java` – Core Kd-Tree implementation.
- `PointSET.java` – Naive point set implementation for comparison.
- `KdTreeVisualizer.java` – Visualizes Kd-Tree structure.
- `RangeSearchVisualizer.java` – Visualizes range search queries.
- `NearestNeighborVisualizer.java` – Visualizes nearest neighbor queries.
- `README.md` – Project documentation.

---

## Requirements

- Java 8 or higher
- [Princeton Algorithms library](https://algs4.cs.princeton.edu/code/)
- `StdDraw` for visualization

---
