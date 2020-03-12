from wordcloud import WordCloud
from PIL import Image
import numpy as np
import jieba

with open('Data.txt', 'r', encoding='utf-8') as f:
    text = ' '.join(jieba.cut(f.read(), cut_all=False))

wc = WordCloud(
    background_color='black',
    font_path='C:\\Windows\\Fonts\\msyh.ttc',
    width=1080,
    height=2340,
).generate(text)

imageFile = wc.to_image()
imageFile.save("image.png")
imageFile.show()
