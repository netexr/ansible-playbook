#!/bin/bash

case $1 in
  start)
    nohup java Test &
    ;;
  stop)
    ps aux|grep java|grep Test|awk '{print $2}'|xargs kill
    ;;
  *)
    echo "Usage $0 [start] [stop]"
esac
    
