# Java_Project
# Async Processing & Error Handling in Java

## Overview
This project demonstrates asynchronous processing and error handling using CompletableFuture in Java.

## Features
- Asynchronous data loading using a custom thread pool
- Data processing pipeline (thenApply)
- Centralized error handling (exceptionally)
- Logging with timestamps
- Graceful thread management (ExecutorService)

## Architecture
- Main.java — entry point
- AsyncService.java — business logic
- LoggerUtil.java — logging utility

## Key Concepts
- Non-blocking execution
- Exception handling in async pipelines
- Thread pool management

## Result
The application continues to work even if errors occur, returning fallback data instead of crashing.
