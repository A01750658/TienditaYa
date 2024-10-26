import mysql.connector
from fastapi import FastAPI, HTTPException
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
class VentaItem(BaseModel):
    producto: str
    cantidad: int
    precio: float
class FiadoItem(BaseModel):
    nombre: str
    deuda: float

@app.put("/inventario/data")
def put_inventario(item: InventarioItem):
    '''Update the data from the inventory'''
    try:
        sql = 'UPDATE inventario SET cantidad_producto = %s WHERE nombre_producto = %s'
        val = (item.cantidad, item.producto)
        miCursor.execute(sql, val)
        mydb.commit()
        return {"response": "Data updated"}
    except mysql.connector.Error as err:
        mydb.rollback()
        raise HTTPException(status_code=500, detail=str(err))
    finally:
        miCursor.close()

@app.get("/inventario/data")
def get_inventario():
    '''Get the data from the inventory'''
    miCursor.execute("SELECT * FROM inventario")
    myresult = miCursor.fetchall()
    print(myresult)
    print(type(myresult))
    for t in range(len(myresult)):
        myresult[t] = list(myresult[t])
    for i in myresult:
        print(i)
        print(type(i))
        for j in range(len(i)):
            if type(i[j]) != str:
                i[j] = str(i[j])
    print(myresult)
    print(type(myresult))
    return {"response":myresult}

@app.post("/inventario/data")
def post_inventario(item: InventarioItem):
    '''Post the data into the inventory'''
    sql = 'INSERT INTO inventario VALUES (%s,%s,%s) '
    val=("", item.producto, item.cantidad)
    miCursor.execute(sql, val)
    mydb.commit()
    return {"response":"Data inserted"}

@app.post("/venta/data")
def post_venta(item: VentaItem):
    '''Post the data into the inventory'''
    try:
        sql = 'INSERT INTO ventas VALUES (%s,%s,%s,%s) '
        val = ("", item.producto, item.cantidad, item.precio)
        miCursor.execute(sql, val)
        mydb.commit()
        return {"response": "Data inserted"}
    except mysql.connector.Error as err:
        mydb.rollback()
        raise HTTPException(status_code=500, detail=str(err))
    
@app.post("/compra/data")
def post_compra(item: VentaItem):
    '''Post the data into the inventory'''
    try:
        sql = 'INSERT INTO compras VALUES (%s,%s,%s,%s) '
        val = ("", item.producto, item.cantidad, item.precio)
        miCursor.execute(sql, val)
        mydb.commit()
        return {"response": "Data inserted"}
    except mysql.connector.Error as err:
        mydb.rollback()
        raise HTTPException(status_code=500, detail=str(err))
    
@app.post("/fiado/data")
def post_fiado(item: FiadoItem):
    '''Post the data into the inventory'''
    try:
        sql = 'INSERT INTO fiados VALUES (%s,%s,%s) '
        val = ("", item.nombre, item.deuda)
        miCursor.execute(sql, val)
        mydb.commit()
        return {"response": "Data inserted"}
    except mysql.connector.Error as err:
        mydb.rollback()
        raise HTTPException(status_code=500, detail=str(err))

@app.get("/fiado/data")
def get_fiado():
    '''Get the data from the fiados'''
    miCursor.execute("SELECT * FROM fiados")
    myresult = miCursor.fetchall()
    print(myresult)
    print(type(myresult))
    for t in range(len(myresult)):
        myresult[t] = list(myresult[t])
    for i in myresult:
        print(i)
        print(type(i))
        for j in range(len(i)):
            if type(i[j]) != str:
                i[j] = str(i[j])
    print(myresult)
    print(type(myresult))
    return {"response":myresult}

@app.put("/fiado/data")
def put_fiado(item: FiadoItem):
    '''Update the data from the inventory'''
    try:
        sql = 'UPDATE fiados SET deuda = %s WHERE nombre = %s'
        val = (item.deuda, item.nombre)
        miCursor.execute(sql, val)
        mydb.commit()
        return {"response": "Data updated"}
    except mysql.connector.Error as err:
        mydb.rollback()
        raise HTTPException(status_code=500, detail=str(err))
    finally:
        miCursor.close()