// nochange.js
//   This script illustrates using the focus event
//   to prevent the user from changing a text field

// The event handler function to compute the cost


function computeCost (changed, prices) {

  console.log(changed);

  var french       = document.getElementById("french").value;
  var hazlenut    = document.getElementById("hazlenut").value;
  var columbian = document.getElementById("columbian").value;

  // Compute the cost
  document.getElementById("cost").value = totalCost
      = french * prices[0] + hazlenut * prices[1] +  columbian * prices[2];
}  //* end of computeCost

function checkSubmission()
{
    var french       = document.getElementById("french").value;
    var hazlenut    = document.getElementById("hazlenut").value;
    var columbian = document.getElementById("columbian").value;
    var cost = document.getElementById("cost").value;

    //check for no input
    if(french == "" || hazlenut == "" || columbian == "" || cost == "")
    {
        alert("You did not put a quantity for one or more items or get a cost");
        return false;
    }

    //check for negative numbers
    if(french < 0 || hazlenut < 0 || columbian < 0 || cost < 0)
    {
        alert("You have a negative quantity of items or a negative cost");
        return false;
    }


    return true;

}
