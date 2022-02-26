//Supplemental JS for Matcher2.html
//By Matt McCullough

// The lists of words
//Part 2 Question 1 "foo" works to match all in list 1 and none in list 2
//var wordList = new Array ( "afoot", "catfoot", "dogfoot", "fanfoot", "foody","foolery", "foolish", "fooster", "footage", "foothot", "footle", "footpad", "footway", "hotfoot", "jawfoot", "mafoo", "nonfood", "padfoot", "prefool", "sfoot", "unfool");
//var wordList2 = new Array ( "Atlas", "Aymoro", "Iberic", "Mahran", "Ormazd","Silipan", "altared", "chandoo", "crenel", "crooked", "fardo", "folksy", "forest", "hebamic", "idgah", "manlike", "marly", "palazzi", "sixfold", "tarrock", "unfold");

//Part 2 Question 2 "ick$" works to match all in list 1 and none in list 2
//var wordList = new Array ( "Mick", "Rick", "allocochick", "backtrick", "bestick","candlestick", "counterprick", "heartsick", "lampwick", "lick", "lungsick", "potstick", "quick", "rampick", "rebrick", "relick", "seasick", "slick", "tick", "unsick", "upstick");
//var wordList2 = new Array ( "Kickapoo", "Nickneven", "Rickettsiales", "billsticker", "borickite", "chickell", "fickleness", "finickily", "kilbrickenite", "lickpenny", "mispickel", "quickfoot", "quickhatch", "ricksha", "rollicking", "slapsticky", "snickdrawing", "sunstricken", "tricklingly", "unlicked", "unnickeled");


//Part 2 Question 3 "fu(?![a-z])" works to match all in list 1 and none in list 2 with no $ sign
//var wordList = new Array ( "fu", "tofu", "snafu");
//var wordList2 = new Array ( "futz", "fusillade", "functional", "discombobulated");

//Part 2 Question 4 "[a-f][a-f][a-f][a-f]" works to match all in list 1 and none in list 2
var wordList = new Array( "abac", "accede", "adead", "babe", "bead", "bebed", "bedad", "bedded", "bedead", "bedeaf", "caba", "caffa", "dace", "dade", "daff", "dead", "deed", "deface", "faded", "faff", "feed");
var wordList2 = new Array("beam", "buoy", "canjac", "chymia", "corah", "cupula", "griece", "hafter", "idic", "lucy", "martyr", "matron", "messrs", "mucose", "relose", "sonly", "tegua", "threap", "towned", "widish", "yite");

var match = prompt("Please enter a regular expression pattern", "");


searchArray(wordList, match);
searchArray(wordList2, match);

function searchArray(arr, match)
{
    var matches = 0;

    for(i=0; i<arr.length; i++)
    {
        if(arr[i].search(match) != -1) //find if it is in word
        {
            document.write(arr[i], "<br />");
            matches++;
        }
    }

    if(matches > 1)
        document.write(matches + " matches found <br />");
    else if(matches == 1)
        document.write("1 match found <br />");
    else
        document.write("No matches found <br />");

    document.write("<br />"); //new line to seperate array results

}
