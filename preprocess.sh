grep "LOADED" *.log | grep TRANSACTIONS | awk -F' ' '{print $9"|"$13"|"$15}'