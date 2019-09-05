
APP_NAME=$1

if [ $# -lt 1 ]; then
	echo "usage: $PROG <host-name>"
	ehco "	$PROG spring-sample"
	exit
fi

deploy() {
    echo " * Start deploy..."

    while [ $# -gt 0 ]; do
        local HOST="$1"
        echo " * Deploy to $1..."

        # Start deploy command
        ssh -o StrictHostKeyChecking=no ${HOST} mkdir -p bin webapps log

        scp ../scripts/run.sh ${HOST}:bin/${APP_NAME}.sh
        scp ../build/libs/*.jar ${HOST}:webapps/

        shift
    done

    echo " * Deploy finished."
}

function restart() {
    echo " * Start updating..."

    while [ $# -gt 0 ]; do
        local HOST="$1"
        echo " * Restart $1..."

        # Start update command
        ssh ${HOST} "chmod +x bin/$APP_NAME.sh && bin/$APP_NAME.sh update"

        # End update command
        shift
    done

    echo " * All updated."
}

deploy "$APP_NAME"

restart "$APP_NAME"