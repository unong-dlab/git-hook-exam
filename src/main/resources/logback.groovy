import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import static ch.qos.logback.classic.Level.*

appender("stdout", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%date{HH:mm:ss.SSS} %-5level %logger{35} - %msg -[%thread] %-4relative %n"
    }
}
appender("sql", FileAppender) {
    file = "/tmp/sql.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%date{HH:mm:ss.SSS} %-5level %logger{35} - %msg -[%thread] %-4relative %n"
    }
}
root(INFO, ["stdout"])
logger("org.hibernate.SQL", DEBUG, ["sql"], true)
