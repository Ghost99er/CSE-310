import requests
from bs4 import BeautifulSoup

# Function to scrape a website and process its HTML code
def scrape_and_process(url):
    # Send a GET request to the URL
    response = requests.get(url)
    
    # Check if request was successful
    if response.status_code == 200:
        # Parse the HTML content of the page
        soup = BeautifulSoup(response.content, 'html.parser')
        
        # Process the HTML code as needed
        # For example, you can find specific elements and extract data from them
        # Here's just a simple example of printing the title of the webpage
        print("Title of the webpage:", soup.title.text)
        
        # You can add more processing steps here
        
    else:
        print("Failed to retrieve webpage. Status code:", response.status_code)

# Example usage:
url = 'https://www.byui.edu/catalog/#/courses/414Six2j-?bc=true&bcCurrent=ACCTG100%20-%20Introduction%20to%20Accounting&bcGroup=Accounting&bcItemType=courses'
scrape_and_process(url)
