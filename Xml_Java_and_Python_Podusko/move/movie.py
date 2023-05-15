from bs4 import BeautifulSoup as Soup

if __name__ == '__main__':
    with open(r'movie.xml', encoding='utf-8') as xml_file:
        soup = Soup(xml_file.read(), 'xml') 
    movies = soup.find_all('movie')  
    for movie in movies:
        title = movie.find('title').text.strip()
        genre = movie.find('genre').text.strip()
        director = movie.find('director').text.strip()
        actor=movie.find('actor').text.strip()

        print(f"Title: {title}")
        print(f"Genre: {genre}")
        print(f"Director: {director}")
        print(f"Actor: {actor}")
        print("") 