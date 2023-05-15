import xml.etree.ElementTree as ET

tree = ET.parse('movie.xml')
root = tree.getroot()

for movie in movies:
        title = movie['title']
        year = movie['year']
        director = movie['director']

        print(f"Title: {title}")
        print(f"Year: {year}")
        print(f"Director: {director}")
        print()  # Пустая строка для отделения вывода информации о каждом фильме
