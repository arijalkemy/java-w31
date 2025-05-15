# How to import the ndjson file containing the dashboards and indexes

1. Go to Management → Stack Management.

2. Click on Saved Objects.

3. Click on the Import button.

4. Choose your previously exported .ndjson file.

5. If it references index patterns that don’t exist yet:

    You'll be prompted to re-map them to an existing index pattern.

    Or create the missing index pattern first (e.g., zapatillas).

> Note: The postman collection contains the endpoints for creating and inserting documents for the zapatillas index

The `ClientesData.csv` file contains data for creating the clientes index, which can be imported directly to kibana