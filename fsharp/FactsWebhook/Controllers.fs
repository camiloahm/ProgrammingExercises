namespace FactsWebhook.Controllers

open System
open System.Collections.Generic
open System.Linq
open System.Threading.Tasks
open Microsoft.AspNetCore.Mvc
open Microsoft.WindowsAzure.Storage // Namespace for CloudStorageAccount
open Microsoft.WindowsAzure.Storage.Table // Namespace for Table storage types

[<Route("api/[controller]")>]
type ValuesController() =
    inherit Controller()

    let storageConnString = "DefaultEndpointsProtocol=http;AccountName=camilohbotxjt4cl;AccountKey=pnPB+Nb6NYjLWpWE+pvKbUNodBO77wuBaq6fTT3Woyn0ysn67+2F119n2AlOOCMoyota4+LCesDM04PqoNuZPg=="
    let storageAccount = CloudStorageAccount.Parse(storageConnString)
    let tableClient = storageAccount.CreateCloudTableClient() 

    // GET api/values
    [<HttpGet>]
    member this.Get() = [| "value1"; "value2" |]

    // GET api/values/5
    [<HttpGet("{id}")>]
    member this.Get(id:int) = "value"

    // POST api/values
    [<HttpPost>]
    member this.Post([<FromBody>]value:string) =
        let table = tableClient.GetTableReference("Fact")
        table.CreateIfNotExistsAsync()
        let customer = Customer("Walter", "Harp", "Walter@contoso.com", "425-555-0101")
        let insertOp = TableOperation.Insert(customer)
        table.ExecuteAsync(insertOp)   

    // PUT api/values/5
    [<HttpPut("{id}")>]
    member this.Put(id:int, [<FromBody>]value:string) = ()

    // DELETE api/values/5
    [<HttpDelete("{id}")>]
    member this.Delete(id:int) = ()


type Customer(firstName, lastName, email: string, phone: string) =
    inherit TableEntity(partitionKey=lastName, rowKey=firstName)
    new() = Customer(null, null, null, null)
    member val Email = email with get, set
    member val PhoneNumber = phone with get, set


