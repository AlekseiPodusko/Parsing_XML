import xml.etree.ElementTree as ET

tree = ET.parse('movie.xml')
root = tree.getroot()

for movie in movies:
         title = movie.find("title").text
                st.header(title)
        for i in movie.find("genre"):
                st.text(s.text)
        for s in movie.find("release_date"):
                st.text(s.text)
        for c in movie.find("director"):
                st.text(s.text)
        for v in movie.find("cast"):
                st.text(i.get("title")+"->"+i.get("actor"))
