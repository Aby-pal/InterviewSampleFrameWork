Page Title: interviewsampleframework

#Object Definitions
====================================================================================
icon_hamburger                              id                              nav-hamburger-menu
option_hamburger                            xpath                           //a[@class="hmenu-item"]/div[text()='${option}']
Header_hamburger                            xpath                           //div[@id="hmenu-customer-name"]/b[text()="Hello, Sign in"]
icon_main_menu                              xpath                           //ul[contains(@class,"hmenu-visible")]//div[text()="main menu"]/i
option_televison                            xpath                           //a[text()="Televisions"]
checkbox_samsung                            xpath                           //div[@id="s-refinements"]//span[text()="Samsung"]/ancestor::a
dropdown_sortby                             css                             [data-action='a-dropdown-button']
option_sortby_dropdown                      xpath                           //a[text()="Price: High to Low"]
results_second_product                      xpath                           (//span[@data-component-type="s-search-results"]//div[contains(@class,"s-main-slot s-result-list")]/div)[3]
section_buy                                 xpath                           //div[@id="buyBoxAccordion"]
input_search                                css                             #twotabsearchtextbox
header                                      tagName                         header

                  