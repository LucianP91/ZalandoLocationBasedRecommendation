# ZalandoLocationBasedRecommendation

Das Party Diel e m m a:

Menschen wollen nicht die gleichen Klamotten tragen, wie Menschen in ihrem Umfeld, um sich individuell von der Masse abheben zu können. Gerade auf einer Party gibt es nichts schlimmeres, als wenn zwei Menschen im gleichen Kleid aufkreuzen. Darum wollen wir Zalando die Möglichkeit geben, Menschen beim Einkauf bereits anzuzeigen, dass ein bestimmtes Kleid bereits häufig in ihrer Region gekauft worden ist und somit die Wahrscheinlichkeit steigt, sein alter ego auf einer Party in gleichem Look wieder anzutreffen. Wenn das Kleid in anderen Städten bereits häufig verkauft wurde bekommt man jedoch keine Nachricht, da man davon ausgehen kann, das die Wahrscheinlichkeit sehr gering ist, dass sich zwei Menschen dann immer noch im gleichen Look über den Weg laufen. Auf Grund der imensen Reichweite von Zalando und vielen Menschen, die sich ihre Kleidung auf der Webseite zulegen, bietet sich gerade hier der Nutzen eines solchen Features an.

Mit einem Klick auf 
http://c343fb98.ngrok.io/
kann man für die nächsten Paar Stunden auf den Server zugreifen, um die Funktionaliät einfach mal auszuprobieren und wild aus den neusten Modetrend aus Mailand auszuwählen, welches Kleid man für den nächsten Hackathon tragen möchte ;)
Ein passender Anwendungsfall wäre, mit mehreren (simulierten) IPs etwa aus Aachen oder München das selbe Kleid kauft. Vor dem dritten Kauf zeigt die Detailseite an, dass dieses schon "oft" (2x) in der gleichen Stadt gekauft wurde. Dann werden drei Empfehlungen angezeigt, die man als Alternativen kaufen kann - dabei werden auch dort die bereits in der Stadt gekauften Kleider berücksichtigt.

Eine mögliche Erweiterung ist eine Integration eines Event-Kalenders wie dem von Facebook. So kann eine Warnung eines gleichen Kleides sogar für bestimmte Events angezeigt werden.


Create a new feature for the Zalando store which will check how often the chosen article was bought close to your location.

Download the code. 
Checkout project in IntelliJ.

Im Ordner Frontend die Datei kann ignoriert werden, wird nicht verwendet.

Im Ordner Backend.src.com.hackathon ist das Backend implementiert. Außer der Datei MyServlet, die gehört eigentlich zum Frontend, ist aber irgendwie noch im Backendordner.

Die ganzen Files (außer MyServlett) sollten alle mit JavaDoc versehen sein.

Im Web-Ordner haben wir unser Frontend untergebracht.

Der Server läuft mit Tomcat. War ganz schön schwierig. 
Beim Serverstart wird die index.jsp angezeigt, wobei über das My Servlet die aktuellen top Ten Kleider geladen werden.

Wenn man auf ein Kleid klickt, wird man auf die dressPage.jsp weitergeleitet, welche das ActionServlet nutzt, um von dem ausgewählten Kleid anhand der Id und der Ip zu bestimmen, welcher Preis/Name/Bild angezeigt werden soll und bei Bedarf (wenn bereits zwei Menschen aus der gleichen Region das Kleid gekauft haben) alternative Kleider vorschlägt (die auch dem Kriterum entsprechen).

Vor dem Klick auf ein Kleid in der Übersicht sollte eine anhand der IP Adresse ein Ort festgelegt werden, von wo aus das Kleid gekauft werden soll. (Die IP wird dann auf eine Position umgerechnet und dann wird verglichen, wie viele andere Menschen im 10 Kilometer umkreis der letzten 30 Tage das Kleid auch gekauft haben.)
