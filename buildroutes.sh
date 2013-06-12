#!/bin/bash
JSFILE=public/javascripts/routes.js
curl http://localhost:9000/assets/javascripts/dev-routes.js > ${JSFILE};
sleep 3;
echo "===================="
echo "Route files created."