import sys
from googleplay_api import GooglePlayApi

gpa = GooglePlayApi()

queryText = None

if len(sys.argv) > 1:
	queryText = '%20'.join(sys.argv[1:])

print 'Searching for ' + queryText

appList = gpa.searchApp(queryText)

print 'found %d apps:' % len(appList)

for a in appList : 
	print ' * ' + a['app_name'] + ' (' + a['app_package'] + ')'
