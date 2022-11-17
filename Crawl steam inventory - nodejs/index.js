
const puppeteer = require('puppeteer');

const idSteam = "76561198088243719";
const dotaInventory = "#570";
const csgoInventory = "#730";

async function loadInventoryThenGetItems(typeInventory) {
    const browser = await puppeteer.launch({
        headless: false,
      });


    //---- Load ko hiện browser
    // const browser = await puppeteer.launch();

    const page  = await browser.newPage();
    await page.goto("https://steamcommunity.com/profiles/" + idSteam +"/inventory/" + typeInventory);

    try {
        await page.evaluate(async () => {
            await new Promise((resolve) => {
                var totalHeight = 0;
                var distance = 150;
                var timer = setInterval(() => {
                    var scrollHeight = document.body.scrollHeight;
                    window.scrollBy(0, distance);
                    totalHeight += distance;
    
                    if(totalHeight >= scrollHeight - window.innerHeight){
                        clearInterval(timer);
                        resolve();
                    }
                }, 150);
            });
        });
    } catch (error) {
        console.log(error);
    };


    
    const listItems = await page.$$eval('.itemHolder div[id]', listItems => listItems.map(item => item.getAttribute('id').slice(6)));
    for (let item of listItems) {
        console.log(item);
    };

    const jsonString = JSON.stringify(listItems);
    console.log(jsonString);

    await browser.close();   
};

loadInventoryThenGetItems(dotaInventory);

