//Supplemental JS for Matcher.html
//By Matt McCullough

// The original list of words .* matches all of these
var name_list = new Array ( "anyway", "bone", "cinema", "cover", "define","economy", "eleven", "eye", "hesitate", "key", "majority", "music", "palace", "potato", "relax", "royal", "surely", "typical", "vocabulary", "water");


var match = prompt("Please enter a regular expression pattern", "");

var matches = 0;

for(i=0; i<name_list.length; i++)
{
    if(name_list[i].search(match) != -1) //find if it is in word
    {
        document.write(name_list[i], "<br />");
        matches++;
    }
}

if(matches > 1)
    document.write(matches + " matches found");
else if(matches == 1)
    document.write("1 match found");
else
    document.write("No matches found");
