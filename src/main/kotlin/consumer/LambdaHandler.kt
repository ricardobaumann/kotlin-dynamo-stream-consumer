package consumer

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent
import java.io.InputStream
import java.io.OutputStream
import java.util.*


class LambdaHandler : RequestHandler<DynamodbEvent,Map<String,String>> {
    override fun handleRequest(input: DynamodbEvent?, context: Context?): Map<String, String> {
        input?.records!!.forEach { dynamodbStreamRecord ->
            val keys  = dynamodbStreamRecord.dynamodb.newImage["id"]
            println("Got an update on $keys")
        }
        return Collections.emptyMap()
    }


}