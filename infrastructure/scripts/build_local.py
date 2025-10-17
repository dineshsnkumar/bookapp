import pandas as pd
import argparse
from pymongo import MongoClient


def get_environment():
    """
       Reads data from an Excel file and inserts it into a MongoDB collection.

       Args:
           path_to_file (str): Path to the Excel file.
           sheet_name (str): Name of the sheet to read from.
           mongo_uri (str): MongoDB connection URI (e.g., "mongodb://localhost:27017/").
           db_name (str): Name of the MongoDB database.
           collection_name (str): Name of the MongoDB collection.
    """
    parser = argparse.ArgumentParser()
    parser.add_argument("-path_to_file", help="Location where the data is present")
    parser.add_argument("-sheet_name", help="Location where the data is present")
    parser.add_argument( "url", help="Location where the data is present")
    parser.add_argument("-db_name", help="Location where the data is present")
    parser.add_argument("-collection_name", help="Location where the data is present")
    return parser.parse_args()



def push_data_to_mongodb():
    args = get_environment()
    print(args)


push_data_to_mongodb()