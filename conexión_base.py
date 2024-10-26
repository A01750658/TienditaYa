import mysql.connector
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()
mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",
    database="tienditaya"
)

miCursor = mydb.cursor()
class InventarioItem(BaseModel):
    producto: str
    cantidad: int

@app.put("/inventario/data")
def put_inventario(producto: str, cantidad: int):
    '''Put the data into the inventory'''
    sql = 'INSERT INTO inventario VALUES (%s,%s,%s) '
    val=("", producto, cantidad)
    miCursor.execute(sql, val)
    mydb.commit()
    return {"response":"Data inserted"}