import xml.etree.ElementTree as ET

tree = ET.parse('movie.xml')
root = tree.getroot()

for movie in movies:
        title = movie['title']
        release_date = movie['release_date']
        director = movie['director']

        print(f"Title: {title}")
        print(f"Release_date: {release_date}")
        print(f"Director: {director}")
        print()  
