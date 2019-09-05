SCRIPT_FILE="$(basename $0)"
PROG="${SCRIPT_FILE%.*}"
JAR_FILE="$PROG-current.jar"

if [ $# -lt 1 ]; then
  echo "Usage: $0 [ start | stop | restart ]"
  exit
fi

cd $(dirname $0)
SCRIPT_DIR=$(pwd)
BASE_DIR=$(dirname $SCRIPT_DIR)

BIN_DIR=$BASE_DIR/bin
LOG_DIR=$BASE_DIR/log
APP_DIR=$BASE_DIR/webapps

JAR_FILE=$APP_DIR/$JAR_FILE
PID_FILE="${LOG_DIR}/.${PROG}.pid"

PROFILE=$(cat "${APP_DIR}/${PROG}.profile")

status() {
  local PID=$(cat "$PID_FILE")
  if kill -0 "$PID" >/dev/null 2>&1; then
    echo " * The process($PID) is alive."
  else
    echo " * The process is not alive."
    rm -f "$PID_FILE"
  fi
}

stop() {
  if [ -f "$PID_FILE" ]; then
    local SHEEP=0
    local PID=$(cat "$PID_FILE")
    if kill -0 "$PID" >/dev/null 2>&1; then
      echo " * Trying to shutdown..."
      kill "$PID"
      while sleep 1; do
        kill -0 "$PID" >/dev/null 2>&1 || break
        echo "$((++SHEEP)) sec..."
      done
    else
      echo " * The process is not alive."
    fi

    rm -f "$PID_FILE"
  else
    echo " * The process-id not found."
  fi
}

start() {
  echo " * Starting $PROG [$(basename "$JAR_REAL_FILE")]"

  local LOG_FILE="$LOG_DIR/$PROG.log"
  local ERR_FILE="$LOG_DIR/$PROG-err.log"

  local OPTS="-Dspring.profiles.active=$PROFILE"

  nohup java $OPTS -jar "$JAR_REAL_FILE" >>$LOG_FILE 2>>$ERR_FILE </dev/null &
  local PID=$!

  sleep 5

  if kill -0 "$PID" >/dev/null 2>&1; then
    echo "$PID" >"$PID_FILE"
    echo " * Started successfully. $PID"
  else
    echo " * Start failed."
  fi
}

restart() {
  stop && start
}

update() {
  echo " * Updating..."

  ln -sf $LATEST_FILE $JAR_FILE
  JAR_REAL_FILE=$(readlink -f -n "$JAR_FILE")

  restart
}

LATEST_FILE="$(ls -1 $APP_DIR/$PROG-[0-9]*.jar | sort -r -u | head -n 1)"

ln -sf $LATEST_FILE $JAR_FILE
JAR_REAL_FILE=$(readlink -f -n "$JAR_FILE")

$1

