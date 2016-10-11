from bs4 import BeautifulSoup
import urllib2

# Unofficial Google Play API
# Created by: Ilario Dal Grande <info@silentfrog.net>

class GooglePlayApi :

	def __init__(self): 
		self.BASE_URL = 'https://play.google.com/store/search'
		self.DOMAIN_URL = 'https://play.google.com'

	def searchApp(self, text) :
		return self.search(text, 'apps')


	def searchMagazine(self, text) :
		return self.search(text, 'magazines')


	def searchBook(self, text) :
		return self.search(text, 'books')


	def searchMusic(self, text) :
		return self.search(text, 'music')


	def searchMovie(self, text) :
		return self.search(text, 'movies')


	def search(self, text, category=None) :
		url = self.BASE_URL + "?q=" + text
		if category is not None :
			url += "&c=" + category

		print 'url: ', url

		html_doc = urllib2.urlopen(url).read()

		soup = BeautifulSoup(html_doc, 'html.parser')

		return self.__parseResult(soup)


	def __parseResult(self, soup) :
		cards = soup.find_all('div', 'card')

		apps = []
		for card in cards :
			pkg = card['data-docid']
			target = card.find('div', 'cover').find('a', 'card-click-target')
			url = self.DOMAIN_URL + target['href']
			appName = target['aria-label'].strip()
			imgUrl = card.find('img', 'cover-image')['src']
			appAuthor = card.find('a', 'subtitle')['title']

			app = {
				'app_package': pkg,
				'app_name': appName,
				'app_author': appAuthor,
				'app_url': url,
				'app_icon_url': imgUrl
			}

			apps.append(app)
