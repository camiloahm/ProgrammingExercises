using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace azurekeyvault.Controllers
{
    [Route("api/[controller]")]
    public class ValuesController : Controller
    {


        // GET api/values
        [HttpGet]
        public async Task<string> Get()
        {
            return await EnvironmentSecretProvider.GetSecret("https://run-dev-kv.vault.azure.net/secrets/camilo/79e159a3ea5d44788bde363396f112ca");
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody]string value)
        {
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
