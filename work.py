import pandas as pd
from wordcloud import WordCloud
import matplotlib
import matplotlib.pyplot as plt
matplotlib.rcParams['figure.figsize']=(10.0,5.0)

wordcloud=WordCloud(font_path='test5/data/simhei.ttf',background_color='white',max_font_size=80)
word_stat=pd.read_csv(r'test5\\三国演义词频.txt',sep='\t',header=None,encoding='utf-8')
word_freq={x[0]:x[1] for x in word_stat.values}
wordcloud=wordcloud.fit_words(word_freq)
plt.imshow(wordcloud)
plt.show()
